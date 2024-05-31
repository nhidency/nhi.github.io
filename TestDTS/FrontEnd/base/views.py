from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse
# Create your views here.
def base(request):
       context={}
       return render(request, 'pages/base.html', context)
