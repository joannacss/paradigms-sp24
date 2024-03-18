from django.urls import path
from .views import  index

from .views import  ViewQuestions
urlpatterns = [
    path("", ViewQuestions.as_view(), name="index"),

]