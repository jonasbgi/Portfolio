import string
import csv

#Part 1: Read from file
#Input: Filename // Return: File content as string
def read_from_file(filename):
    file = open(filename, 'r')
    return file.read()

#Part 2: Remove symbols
#Input 'text' as string // Return: String without symbols (.,; etc except 'space')
def remove_symbols(text):
    for a in string.punctuation:
        text = text.replace(a,'')
    for b in string.digits:
        text = text.replace(b, '')
    text = text.replace("\n"," ")
    text = text.replace("\t", " ")
    return text.lower()

#Part 3: Count words. Similar to usual main-method.
#Input: Filename // Output: Dict with unique words as keys and instances as values
def count_words(filename):
    text = remove_symbols(read_from_file(filename))
    words = text.split(" ")
    wordCount = {}
    for a in words:
        a.strip()
        if len(a) > 0:
            if a not in wordCount.keys():
                wordCount[a] = 1
            else:
                wordCount[a] += 1
    for b in sorted(wordCount.keys()):
        print(b, wordCount[b], sep=": ")
    dict_to_csv(wordCount, "dictionary.csv")
    #return wordCount

#BONUS: Writes dictionary d to a .csv-file.
#Input: Dictionary and filename (String) // Returns nothing, outputs to file.
def dict_to_csv(d, filename):
    try:
        csvFile = open(filename,"w")
        dWriter = csv.writer(csvFile, dialect='excel')
        for x in sorted(d.keys()):
            dWriter.writerow([x, d[x]])
    except PermissionError:
        print("Please close ", filename)

count_words("BIBLE.txt")