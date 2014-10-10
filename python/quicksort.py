def quicksort(A, i, k):
    if i < k:
        p = partition(A, i, k)
        quicksort(A, i, p - 1)
        quicksort(A, p + 1, k)


def partition(array, left, right):
    pivotindex = left + (right - left) // 2
    pivotValue = array[pivotindex]
    swap = array[pivotindex]
    array[pivotindex] = array[right]
    array[right] = swap
    storeindex = left
    for i in range(left, right):
        if array[i] < pivotValue:
            s = array[i]
            array[i] = array[storeindex]
            array[storeindex] = s
            storeindex = storeindex + 1
    swa = array[storeindex]
    array[storeindex] = array[right]
    array[right] = swa
    return storeindex


def run():
    A = [9, 3, 6, 8, 2, 4, 7, 5, 1, 3, 12, 0]
    quicksort(A, 0, len(A) - 1)
    print(A)


run()
