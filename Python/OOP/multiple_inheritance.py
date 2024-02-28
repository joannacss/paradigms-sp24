from animal import Cow


class Vocalizer:
    def speak(self):
        return "method Vocalizer.speak() invoked"


class EvilCow(Vocalizer, Cow):
    def sound(self):
        return "moo ha ha mwahaha"


if __name__ == '__main__':
    c = EvilCow('Bessie')
    print(c.speak()) # what the output should be in here?
    print(EvilCow.mro())