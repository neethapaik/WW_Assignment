import os.path
def doesFileExist(path):
     print(os.path.exists(path))
     try:
         my_file = open(path)
     except IOError:
         os.touch(path)
def readvalue(path):
    d = {}
    with open(path) as f:
        d = {k: [x.strip() for x in v.split(',')] for k, v in (line.split(':') for line in f)}
    for key in d:
        print(key)
        for i in d[key]:
            print(i)


path = input("Enter the relative file path. (Ex: if the file is outside the work directory then use ../../../{foldername}/{filename}")
doesFileExist(path)
readvalue(path)