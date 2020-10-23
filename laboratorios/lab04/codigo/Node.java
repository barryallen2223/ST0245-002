
class Node
{
    Bee data;
    Double distance;
    Node left;
    Node right;

    Node(Bee data) {
        this.data = data;
        distance = 0.0;
        right = null;
        left = null;
    }
    
    Node(Bee data, Double distance) {
        this.data = data;
        this.distance = distance;
        right = null;
        left = null;
    }
}