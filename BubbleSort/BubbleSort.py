#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jul 14 12:38:58 2019

@author: joseph
"""

from pandas import read_csv
from sys import argv
# Bubble Sort Algorithm
# Repeatedly sends big elements to the end of the list
# Mutates data
def bubbleSort(data):
    # it takes len(data) - 1 iterations to move an element from the back
    # of the list to the front. Loop len(data) - 1 times
    for start in range(0, len(data) -1):
        # The greatest element is always at the back after each iteartion
        # move through the list from front to back, moving an element forward
        # Each iteration
        for target in range(0, len(data)-1-start):
             # Swap elements when you need to.
            if data[target+1] < data[target]:
                data[target+1],data[target] = data[target],data[target+1]
    
# Program's main function. Reads and bubblesorts data            
def main(filename):
    assert len(filename)>4 and filename[-4:] == '.csv', "Please supply a .csv file"
    # Read data from the filename into a pandas dataframe
    data = read_csv(filename, sep=',')
    
    # Bubblesort it
    bubbleSort(data['Random_Values'])
    # and print it
    print(data['Random_Values'])
    
    
# Start the program
if __name__ == '__main__':
    # With the proper number of arguments
    if len(argv) != 2:
        print('Usage: python BubbleSort.py [dataFileVec]')
    # Starts the main function with the proper filename
    main(argv[1])