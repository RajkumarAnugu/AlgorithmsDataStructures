v = [18, 27, 49, 40, 24, 22, 29, 10, 24, 40 ]
w = [320,301,371,296,303,359,148,275,296,395]
#kapasitet 
k = 720
def main(v, w, k):
    # priority: max value per weight
    p = {} # priority dict
    for i in range(len(v)):
        p[i] = (v[i]*1.0)/w[i]

    #priority by value list
    pv = list (p.values())
    pv.sort()
    print (pv)
    index = 0
    for key, pvalue in p.iteritems():
        if pvalue == max(pv):
            index = key
    print ("priority pair:",v[index],w[index])
    load = 0
    # list of all possible result
    result=[]
    for i in range(len(w)):
        recursion(v,w,k,load,w[i],result)
    print(result)
    print(max(result))
def recursion(v,w,k,load,weight,result):
    if load == k: return
    if load + min(w) > k: return
    load+=weight
    for i in range(len(w)):
        if weight+w[i]<=k:
            result.append(v[w.index(weight)]+v[i])
            load+=w[i]
    if load < k:
        weight = 0
        recursion(v,w,k,load,weight,result)

main(v, w, k)
