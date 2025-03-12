package ObserverDesign;
interface Obserable {
    // states
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}