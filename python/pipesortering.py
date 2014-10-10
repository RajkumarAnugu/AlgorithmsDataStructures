from sys import stdin


def sorter(A):
    # Merk: den sorterte lista ma returneres
    # SKRIV DIN KODE HER
    quicksort(A, 0, len(A) - 1)


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


def finn(A, nedre, ovre):
    # Merk: resultatet ma returneres
    # SKRIV DIN KODE HER
    limits = [None] * 2
    for i in A:
        if i <= nedre:
            limits[0] = i
        if i >= ovre:
            limits[1] = i
            break
    if limits[1] == None:
        limits[1] = A[-1]
    if limits[0] == None:
        limits[0] = A[0]

    return limits
#


liste = []
for x in stdin.readline().split():
    liste.append(int(x))
sortert = sorter(liste)
for linje in stdin:
    ord = linje.split()
    minst = int(ord[0])
    maks = int(ord[1])
    resultat = finn(sortert, minst, maks)
    print str(resultat[0]) + " " + str(resultat[1])
