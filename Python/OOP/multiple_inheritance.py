from animal import Cow
import os

class Vocalizer:
    def speak(self):
        return "method Vocalizer.speak() invoked"


class EvilCow(Vocalizer, Cow):
    def sound(self):
        try:
            from playsound import playsound
            current_dir = os.path.dirname(os.path.realpath(__file__))
            playsound(os.path.join(current_dir, 'sound', 'ringtones-vaca-loca.mp3'))
        except:
            print('You likely forgot to pip install playsound PyObjC')


        return "moo ha ha mwahaha"



if __name__ == '__main__':
    c = EvilCow('Bessie')
    print("What does the evil cow says?")
    print(c.sound())
    print(c.speak())  # what the output should be in here?
    print(EvilCow.mro())
