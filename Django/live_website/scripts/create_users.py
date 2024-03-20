import csv
from django.contrib.auth.models import User
from django.core.exceptions import ValidationError
from django.db import IntegrityError, transaction

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
# python3.9 manage.py shell < ./scripts/create_users.py

add_users_from_csv(csv_file_path)
