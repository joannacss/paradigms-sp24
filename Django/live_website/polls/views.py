from django.http import HttpResponseRedirect
from django.shortcuts import render, get_object_or_404
from django.views.generic import ListView, DetailView
from .models import Question, Choice


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
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
        # return Question.objects.all() # This returns all questions in the database


class QuestionView(DetailView):
    model = Question
    template_name = "polls/detail.html"



def vote(request, pk):
    question = get_object_or_404(Question, pk=pk)
    try:
        selected_choice = question.choice_set.get(pk=request.POST['choice'])
    except (KeyError, Choice.DoesNotExist):
        # Redisplay the question voting form.
        return render(request, 'polls/detail.html', {
            'question': question,
            'error_message': "You didn't select a choice.",
        })
    else:
        selected_choice.votes += 1
        selected_choice.save()
        return HttpResponseRedirect("/polls")



class ResultsView(DetailView):
    model = Question
    template_name = "polls/results.html"