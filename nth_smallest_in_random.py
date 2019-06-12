import random
n = int(input("Enter the nth smallest number required: "))
my_randoms = random.sample(range(10000), 500)
arr = list(dict.fromkeys(my_randoms))
arr.sort()
if(n<=0):
    print("Please enter a number which is positive and greater than 0")
elif(len(arr) > n):
    print(n," smallest element is ",arr[n-1])
else:
    print("selected value is greater than the length of the list")



