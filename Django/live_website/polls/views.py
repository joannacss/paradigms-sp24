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


class IndexView(ListView):
    template_name = 'polls/list_questions.html'
    context_object_name = 'latest_questions'

    def get_queryset(self):
        """TODO: Return the last five published questions."""
        # Implementation below returns *all* questions
        return Question.objects.all()




