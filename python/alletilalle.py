from sys import stdin, maxint

def korteste_rute(rekkefolge, nabomatrise, byer):
    # SKRIV DIN KODE HER
    distansematrise = floydwarshall(nabomatrise, byer)
    distanse = 0
    for i in range(len(rekkefolge)):
        distanse += distansematrise[rekkefolge[i]][rekkefolge[(i + 1) % byer]]
    if distanse >= maxint / 3: distanse = "umulig"
    return distanse

def floydwarshall(nabomatrise, n):
    for k in range(n):
        for i in range(n):
            for j in range(n):
                nabomatrise[i][j] = min(nabomatrise[i][j], nabomatrise[i][k] + nabomatrise[k][j])

    return nabomatrise

testcases = int(stdin.readline())                               #line 1:    2
print "testcases: (loop)", testcases
for test in range(testcases):
    print "test:",test
    byer = int(stdin.readline())                                #line 2:    3
    print "byer:", byer
    newline = stdin.readline()                                  #line 3:    0 2 1
    print "newline: ", newline
    rekkefolge = [int(by) for by in newline.split()]
    nabomatrise = []
    for by in range(byer):
    # SKRIV DIN KODE HER
        naboer = list()
        for distanse in stdin.readline().split():               #line 4:    0 1 2
            distanse = int(distanse)
            if distanse == -1: distanse = maxint / 3
            naboer.append(distanse)
        nabomatrise.append(naboer)
    print korteste_rute(rekkefolge, nabomatrise, byer)
