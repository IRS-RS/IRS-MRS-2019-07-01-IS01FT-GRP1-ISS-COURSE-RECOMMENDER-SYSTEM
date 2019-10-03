import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from apyori import apriori

file1 = open("rule_List1.txt","a")#append mode 
 

store_data = pd.read_csv('prereq_data - Copy.csv', header=None)

store_data.head()

records = []
for i in range(0, 30):
    print(i)
    records.append([str(store_data.values[i,j]) for j in range(0, 9)])
    
association_rules = apriori(records, min_support=0.0045, min_confidence=0.2, min_lift=3, min_length=2)
association_results = list(association_rules)

print(len(association_results))

print(association_results[0])

for item in association_results:
  
    # first index of the inner list
    # Contains base item and add item
    pair = item[0] 
    items = [x for x in pair]
    print("Rule: " + items[0] + " -> " + items[1])
    file1.write(f"Rule: " + items[0] + " -> " + items[1]+"\n")
    #second index of the inner list
    print("Support: " + str(item[1]))
    file1.write(f"Support: " + str(item[1])+"\n")
    #third index of the list located at 0th
    #of the third index of the inner list

    print("Confidence: " + str(item[2][0][2]))
    file1.write(f"Confidence: " + str(item[2][0][2])+"\n")
    print("Lift: " + str(item[2][0][3]))
    file1.write(f"Lift: " + str(item[2][0][3])+"\n")
    print("=====================================")
    file1.write("====================================="+"\n")
    
    
file1.close()
