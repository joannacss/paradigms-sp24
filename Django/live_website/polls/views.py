from django.shortcuts import render
from django.views.generic import ListView
from .models import Question

# Create your views here.
def index(request):
    context = {
        "course": "Paradigms",
        "semester": "Spring 2024",
    }
    return render(request, "index.html", context)


class ViewQuestions(ListView):
    model = Question
    def get_queryset(self):
        #  a list of all questions
        return Question.objects.all()
