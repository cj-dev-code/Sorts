//
// Created by Joseph Islam on 7/14/19.
//

#include <iostream>
#include <array>
#include <vector>

#include <fstream>

using namespace std;

static void BubbleSort(vector<int> &data){
    // it takes data.size() - 1 steps to move the smallest element at the back to the front of the vector
    // Loop data.size() - 1 times
    for (int start = 0; start < data.size() - 1; start++){
        // The greatest element is always at the back after each iteration
        // move through the list from front to back, moving big elements to the back of the list
        for (int target = 0; target < data.size() - 1 - start; target++){
            // Swap if a big element is before a little element
            if (data[target] > data[target+1]){
                // Swap without using a new variable.
                data[target] = data[target] + data[target+1];
                data[target+1] = data[target] - data[target+1];
                data[target] = data[target] - data[target+1];
            }
        }
    }
}

// Reads files in format: str\nint\nint\nint... format
// And returns data in a vector
static vector<int> read_dataVec(const string& filename){
    // Create a vector to store the working data in,
    vector<int> data = vector<int>();
    //  a file to read from,
    ifstream csv(filename);
    // and a line store data in.
    string line;

    // Read through the file on opening
    if (csv.is_open()){
        // Storing each newline in line
        while (getline(csv, line)){
            // And storing potential ints in data.
            try{
                data.push_back(stoi(line));
            }
            catch (invalid_argument e){}
        }
        // Close the file when finished
        csv.close();
    } else{
        // If the file is not open, say so, and yield error code 11
        cout << "Unable to open file";
    }

    // Return data
    return data;
}

int main(int argc, char* argv[]){
    // Make sure user supplies vector filename and vector filename alone
    if (argc != 2){
        printf("Usage: ./main [dataVectorFilename]");
        return 0;
    }

    // Get filename to read data from from commandline args
    string filename = argv[1];

    // Get the data out of that file
    vector<int> data = read_dataVec(filename);

    // And sort it with Bubble Sort
    BubbleSort(data);

    // Finally, print the sorted data
    for (int element: data){
        cout << element << ", ";
    }

    // And return 1 for successful completion
    return 1;
}