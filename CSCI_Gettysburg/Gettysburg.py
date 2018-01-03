def totalWordCount1(full):
    totalWordCount = len(full.split())
    return totalWordCount


def totalWordCount2(full):
    wordFrequency = {} # this is a dictionay, not a set
    for word in full.split():
        if word not in wordFrequency:
            wordFrequency[word] = 1
        else:
            wordFrequency[word] += 1
            
    totalWordCount = sum(wordFrequency.values())
    return totalWordCount

def uniqueWordCount1(full):
    uniqueWords = set(full.split())
    uniqueWordCount = len(uniqueWords)
    return uniqueWordCount    
    
def uniqueWordCount2(full):
    uniqueWords = set()
    for word in full.split():
        uniqueWords = uniqueWords.union({word})
        
    uniqueWordCount = len(uniqueWords)
    return uniqueWordCount

def uniqueWordCount3(full):
    wordFrequency = {} # this is a dictionay, not a set
    for word in full.split():
        if word not in wordFrequency:
            wordFrequency[word] = 1
        else:
            wordFrequency[word] += 1
            
    uniqueWordCount = len(wordFrequency.keys())
    return uniqueWordCount
    

def main():
    gb = open('gettysburg.txt', 'r')

    # save the entire contents of the file to a string called full
    full = gb.read()
    gb.close()
    
    # replace punctuation and new lines with spaces
    full = full.replace('.', ' ')
    full = full.replace(',', ' ')
    full = full.replace('\n', ' ')
    full = full.replace('--', ' ')
    
    print('Total Word Count 1:', totalWordCount1(full))
    print('Total Word Count 2:', totalWordCount2(full))
    print('Unique Word Count 1:', uniqueWordCount1(full))
    print('Unique Word Count 2:', uniqueWordCount2(full))
    print('Unique Word Count 3:', uniqueWordCount3(full))    
main()