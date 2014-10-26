from sys import stdin, stderr

def beste_sti(nm, sans):
    # SKRIV DIN KODE HER
    n = len(sans)
    ferdig = [False] * n
    ksans = [0.0] * n # kummulativ sannsynlighet
    ksans[0] = sans[0]
    forrige = range(n)
    beste_node = 0
    for i in range(n):
        node = beste_node
        ferdig[node] = True
        hoyeste_ksans = -1.0
        for nabo in range(n):
            if not ferdig[nabo]:
                if nm[node][nabo]:
                    tilbud = ksans[node] * sans[nabo]
                    if tilbud > ksans[nabo]:
                        forrige[nabo] = node
                        ksans[nabo] = tilbud
                if ksans[nabo] > hoyeste_ksans:
                    beste_node = nabo
                    hoyeste_ksans = ksans[nabo]

    if (ksans[-1] == 0.0):
        return '0'
    index = n - 1
    sti = []
    while index != 0:
        sti.append(index)
        index = forrige[index]
    sti.append(0)
    return '-'.join(map(str, reversed(sti)))

n = int(stdin.readline())
sannsynligheter = [float(x) for x in stdin.readline().split()]
nabomatrise = []
for linje in stdin:
    naborad = [0] * n
    naboer = [int(nabo) for nabo in linje.split()]
    for nabo in naboer:
        naborad[nabo] = 1
    nabomatrise.append(naborad)
print beste_sti(nabomatrise, sannsynligheter)

'''Rammeverket i denne oppgaven gir to variabler.
'Nabomatrise'er en liste bestaaende av n lister med  (antall noder) elementer.
Elementet paa posisjon 'i' i liste 'j' (i,j < n) forteller oss om det
eksisterer en kant fra node nummer 'i' til node nummer 'j'. En kant er representert
med et 1-tall. 'Nabomatrise' for eksempelinputet vil bli:
[[0, 1, 1, 0, 0, 0],
 [1, 0, 0, 1, 1, 0],
 [1, 0, 0, 1, 1, 0],
 [0, 1, 1, 0, 0, 1],
 [0, 1, 1, 0, 0, 1],
 [0, 0, 0, 1, 1, 0]]

'Sannsynligheter' er en liste av lengde n hvor hvert element i listen representerer
sannsynligheten i den tilhorende noden. 'Sannsynligheter' for eksempelinputen vil
bli: [1.0, 0.9, 0.3, 0.1, 0.8, 1.0]
'''
