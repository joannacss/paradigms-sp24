from django.shortcuts import render


def index(request):
    context = {
        "course": "CSE-30332",
        "semester": "Spring 2024",
    }
    return render(request, "polls/index.html", context)
