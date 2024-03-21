from django.urls import path
from .views import IndexView
from .views import QuestionView
from .views import vote
urlpatterns = [
    path("", IndexView.as_view(), name="index"),
    path("<int:pk>/", QuestionView.as_view(), name="detail"),
    path("<int:pk>/vote/", vote, name="vote")
]
