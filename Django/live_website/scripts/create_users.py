import csv
from django.contrib.auth.models import User
from django.core.exceptions import ValidationError, ObjectDoesNotExist
from django.db import IntegrityError, transaction
from django.contrib.auth.models import User, Permission
# Adjust the path to your CSV file as needed
csv_file_path = '/Users/joanna/Downloads/paradigms_sp24_roster.csv'

def add_users_from_csv(file_path):
    with open(file_path, mode='r', encoding='utf-8') as csv_file:
        reader = csv.reader(csv_file)
        for row in reader:
            username, password = row

            try:
                with transaction.atomic():
                    user = User.objects.create_user(username=username)
                    user.set_password(password)
                    user.save()
                    print(f"User {username} added successfully.")
            except IntegrityError:
                print(f"User {username} already exists.")
            except ValidationError as e:
                print(f"Error adding user {username}: {e}")
            except Exception as e:
                print(f"An unexpected error occurred while adding user {username}: {e}")

def add_permissions_to_users(file_path):
    with open(file_path, mode='r', encoding='utf-8') as csv_file:
        reader = csv.reader(csv_file)
        for row in reader:
            username, password = row
            try:
                with transaction.atomic():
                    # Create a new user and mark them as staff
                    user = User.objects.get(username=username)
                    user.is_staff = True
                    # Fetch all permissions related to the 'polls' app models
                    app_permissions = Permission.objects.filter(content_type__app_label='polls')

                    # Assign all these permissions to the user
                    user.user_permissions.set(app_permissions)
                    user.save()

                    print(f"Staff user {username} with 'polls' app permissions added successfully.")
            except ObjectDoesNotExist:
                print(f"User {username} does not exist. No updates made.")
            except ValidationError as e:
                print(f"Error updating user {username}: {e}")
            except Exception as e:
                print(f"An unexpected error occurred while updating user {username}: {e}")


# python3.9 manage.py shell < ./scripts/create_users.py

# add_users_from_csv(csv_file_path)
add_permissions_to_users(csv_file_path)
