from django.urls import path
from .views import IndexView
from .views import QuestionView
from .views import vote
from .views import ResultsView
urlpatterns = [
    path("", IndexView.as_view(), name="index"),
    path("<int:pk>/", QuestionView.as_view(), name="detail"),
    path("<int:pk>/vote/", vote, name="vote"),
    path("<int:pk>/results/", ResultsView.as_view(), name="results"),
]
