from sys import stdin


def sorter(A):
    # Merk: den sorterte lista ma returneres
    # START IKKE-UTDELT KODE
    quicksort(A, 0, len(A) - 1)
    return A


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
    # SLUTT IKKE-UTDELT KODE


def finn(A, nedre, ovre):
    # Merk: resultatet ma returneres
    # START IKKE-UTDELT KODE
    indeks_nedre = binsok(A, nedre)
    indeks_ovre = binsok(A, ovre)
    if A[indeks_nedre] > nedre and indeks_nedre != 0:
        indeks_nedre -= 1
    if A[indeks_ovre] < ovre and indeks_ovre != len(A) - 1:
        indeks_ovre += 1
    return [A[indeks_nedre], A[indeks_ovre]]


def binsok(A, verdi):
    l = 0
    r = len(A) - 1
    while l <= r:
        m = (l + r) // 2
        if verdi == A[m]:
            break
        elif verdi < A[m]:
            r = m - 1
        else:
            l = m + 1
    return m

# SLUTT IKKE-UTDELT KODE

liste = []
for x in stdin.readline().split():
    liste.append(int(x))

sortert = sorter(liste)

for linje in stdin:
    ord = linje.split()
    minst = int(ord[0])
    maks = int(ord[1])
    resultat = finn(sortert, minst, maks)
    print
    str(resultat[0]) + " " + str(resultat[1])