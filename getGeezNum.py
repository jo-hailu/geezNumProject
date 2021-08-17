#!/usr/bin/env python

## this will return geez charactor gevin integer
## there are two sets fo geez charactors and
## integers are combinations of those to sets
def getGeez(num):

    ## we will generate the geez number from combination of those
    ones = ["","፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱"]
    tens = ["","፲", "፳", "፴", "፵", "፶", "፷", "፸", "፹", "፺", "፻"];

    if(num<10):
        return ones[num] ## this is easy

    # for number 10-100
    elif(num>=10 and num<=100):
        if(num/10 == int(num/10)): # if the number ends with zero
            return tens[int(num/10)] # its only one charactor from tens list
        else: # if the number doesn't end with zero its combination of
            # the two lists above
            tensPart = int(num/10) * 10
            onesPart = num - tensPart

            return getGeez(tensPart) + "" + getGeez(onesPart)


     ## for numbers above 100 we split the number into two parts
     ## convert them independently
     ## concatnate them with hundreed in geez in middle
    elif(num>100 and num<10000):
        ## this is two split the first 2 and second 2 charactors in int
        firstPart = int(num/100)
        secondPart = num - firstPart * 100
        ## then return converted part concatnated
        return getGeez(firstPart) + "፻" + getGeez(secondPart)

    ## the same with the above .. thus hundreds in the middle
    elif(num>=10000 and num<10000):
        firstPart = int(num/10000)
        secondPart = num - firstPart*10000

        return getGeez(firstPart) + "፻፻" + getGeez(secondPart)
    else:
        return "out of bound"



## this is for testing
for i in range(100,150):
    print(getGeez(i))
