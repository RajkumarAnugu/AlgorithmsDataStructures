"""
a linked list is a data structure consisting of a group of nodes which together represent a sequence.
Under the simplest form, each node is composed of a data and a reference (in other words, a link)
to the next node in the sequence;\n
Insert / delete:
. Θ(1) when element is known
. Θ(n) when element is unknown
"""


class Node1:
    '''
    a node with only value and a pointer to next Node
    '''

    def __init__(self):
        self.value = None
        self.next = None


def singlePointer():
    '''
    build a single pointet list only next\n
    print the value
    '''
    n1 = Node1()
    n2 = Node1()
    n3 = Node1()
    n1.value = 1
    n2.value = 2
    n3.value = 3
    n1.next = n2
    n2.next = n3

    print("Linked List:\nn1:" + str(n1.value) + "\nn2:" + str(n1.next.value) + "\nn3:" + str(n1.next.next.value))


class Node:
    """
    a Node with double pointer\nnext and previous
    """

    def __init__(self):
        self.value = None
        self.next = None
        self.previous = None


def doublePointer():
    n1 = Node()
    n2 = Node()
    n3 = Node()
    n1.value = 1
    n2.value = 2
    n3.value = 3
    n1.next = n2
    n2.previous = n1
    n2.next = n3
    n3.previous = n2

    print("Linked List:\nn1:" + str(n1.value) + "\nn2:" + str(n1.next.value) + "\nn3:" + str(n1.next.next.value))
    print("Linked List:\nn1:" + str(n3.previous.previous.value) + "\nn2:" + str(n3.previous.value) + "\nn3:" + str(
        n1.next.next.value))
    return n1


def insert(L, n):
    """
        :param L: a linked list
        :param n: a Node
        :return: a linked list with n inserted in front of the Node L
    """
    if L.previous != None:
        n.previous = L.previous
        L.previous.next = n
    n.next = L
    L.previous = n
    return n


def printList(L):
    print("print linked list L: ")
    n = L
    while n.previous != None: n = n.previous
    print("n0: " + str(n.value))
    i = 1
    while n.next != None:
        n = n.next
        print("n" + str(i) + ": " + str(n.value))
        i += 1


def testInsert():
    n0 = Node()
    n0.value = 0
    printList(insert(doublePointer(), n0))


def testInsert2():
    n3 = Node()
    n3.value = 9
    n = doublePointer()
    print("doublePointer(): " + str(n.value))
    n = n.next
    print("doublePointer().next: " + str(n.value))
    n = n.next
    print("doublePointer().next.next: " + str(n.value))
    print("n3: " + str(n.value) + "; n2: " + str(n.previous.value) + "; n1: " + str(n.previous.previous.value))
    n = insert(n, n3)
    print("n: " + str(n.value))
    print("n4: "+str(n.next.value)+"; n3: " + str(n.value) + "; n2: " + str(n.previous.value) + "; n1: " + str(n.previous.previous.value))

    printList(n)
    return n

# testInsert2()

def delete(n):
    """
    :param n: a linked list n
    :return: n removed linked list
    """
    if n.next != None and n.previous != None:
        n.previous.next = n.next
        n.next.previous = n.previous
        return n.previous
    if n.next == None and n.previous == None: return None
    if n.previous == None:
        n.next.previous = None
        return n.next
    if n.next == None:
        n.previous.next = None
        return n.previous
def testDelete():
    n = testInsert2()
    print("n value: "+ str(n.value))
    # n = delete(n)
    n = delete(n.next)
    print("\nTest delete: ")
    printList(n)
testDelete()
