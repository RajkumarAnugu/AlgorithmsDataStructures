# -*- coding: utf-8 -*-
from sys import stdin

def minCoinsGreedy(coins, value):
    # START IKKE-UTDELT KODE
    currentCoin = 0
    numCoins = 0
    while value > 0:
        # print(coins[currentCoin], value)
        if coins[currentCoin] <= value:
            value -= coins[currentCoin]
            numCoins += 1
        else:
            currentCoin += 1
    return numCoins
    # SLUTT IKKE-UTDELT KODE

def minCoinsDynamic(coins, value):
    results = [Inf] * (value + 1)
    usefulCoins = []
    for c in coins:
        if c <= value:
            results[c] = 1
            usefulCoins.append(c)
    for curVal in range(1, value + 1):
        if results[curVal] != Inf:
            continue
        best = Inf
        for c in usefulCoins:
            if c <= curVal:
                current = 1 + results[curVal - c]
                if current < best:
                    best = current
        results[curVal] = best
    return results[value]

def canUseGreedy(coins):
    # bare returner False her hvis du ikke klarer aa finne ut
    # hva som er kriteriet for at den graadige algoritmen skal fungere
    # START IKKE-UTDELT KODE
    for i in range(len(coins) - 1):
        # [1000, 500, 200, 100, 50, 20, 10, 5, 4, 1]
        # graadig gi ikke beste svar hvis coins[i] < coins[i + 1] * 2
        # 8 = 5 + 1 + 1 + 1 vs 8 = 4 + 4
        if coins[i] < coins[i + 1] * 2:
            return False
    return True
    # SLUTT IKKE-UTDELT KODE

Inf = 1000000000
# 'coins' er en liste over de forskjellige myntene man har tilgjengelig. Disse er sortert i synkende rekkefølge.
coins = []
for c in stdin.readline().split():
    coins.append(int(c))
coins.sort()
coins.reverse()
# print(coins)
method = stdin.readline().strip()
if method == "graadig" or (method == "velg" and canUseGreedy(coins)):
    for line in stdin:
        # print("grådig")
        print(minCoinsGreedy(coins, int(line)))
else:
    for line in stdin:
        # print("Dynamic")
        print(minCoinsDynamic(coins, int(line)))