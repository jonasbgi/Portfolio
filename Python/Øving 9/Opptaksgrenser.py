#Part 0: Main function and entering content to variable:
def main():
    csvFile = open("poenggrenser_2011.csv", 'r')
    studier = csvFile.readlines()
    for i in range(0,len(studier)):
        studier[i] = remove_chars(['"','\n'], studier[i])
        studier[i] = studier[i].split(",")
        if studier[i][1].isdigit():
            studier[i][1] = float(studier[i][1])
    print(ant_alle(studier))
    print(avgEntryGrade('NTNU', studier))
    print(findLowest(studier))

#For a selected school, calculates average entry-grade.
def avgEntryGrade(school, list):
    partSum = 0
    parts = 0
    for a in list:
        if a[0].startswith(school):
            if not(a[1] == 'Alle'):
                partSum += float(a[1])
                parts += 1
    return partSum/parts

#Finds lowest entry score except for 0 ('Alle').
#Initial value of 100 much higher than max grade.
def findLowest(list):
    l = [' ', 100]
    for a in list:
        if a[1] != 'Alle':
            if float(a[1]) < l[1]:
                l = [a[0], float(a[1])]
                l[1] = float(l[1])
    return l

#Input: List of chars to remove and String. Returns string w/o input chars.
def remove_chars(chars, string):
    for a in chars:
        string = string.replace(a,'')
    return string

#Counts amount of studies where all students were admitted.
def ant_alle(list):
    count = 0
    for a in list:
        if a[1] == "Alle":
            count += 1
    return count
main()