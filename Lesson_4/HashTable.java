package Lesson_4;


/**
 * HashTable
 */
public class HashTable<K, V> {

    private static final double LOAD_SIZE = 0.75;
    private List<K, V>[] _lists;
    private int _itemsCount;

    public HashTable() {this(4);}

    public HashTable(int len) {
        if (len < 4) _lists = new List[4];
        else _lists = new List[len];
        _itemsCount = 0;
    }

    private int calculateIndex(K key) {
        return Math.abs(key.hashCode() % _lists.length);
    }

    public boolean add(K key, V value) {
        if (_lists.length * LOAD_SIZE < _itemsCount) resize();
        int index = calculateIndex(key);
        List <K, V> list = _lists[index];
        if (list == null) {
            list = new List<>();
            _lists[index] = list;
        }
        boolean added = list.add(key, value);
        System.err.print(String.format("Before added: %d", getCount()));;
        if (added) {
            _itemsCount++;
            System.err.println(String.format(", +1,  To be: %d", getCount()));
        }
        return added;
    }

    public boolean remove(K key) {
        int index = key.hashCode();
        List<K, V> list = _lists[index];
        if (list == null) return false;
        boolean removed = list.remove(key);
        if (removed) _itemsCount--;
        return removed;
    }
    
    private void resize() {
        List<K, V>[] old = _lists;
        _lists = new List[(int) (old.length * 1.5f)];
        for (int i = 0; i < old.length; i++) {
            List<K, V> list = old[i];
            if (list == null) continue;
            List<K, V>.Node currNode = list._root;
            while (currNode != null) {
                this.add((K)currNode._entity._key, (V)currNode._entity._value);
                currNode = currNode._next;
            }
            old[i] = null;
        }
        old = null;
    }

    public V getValue(K key) {
        int index = calculateIndex(key);
        List<K, V> list = _lists[index];
        return list.getValue(key);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < _lists.length; i++) {
            builder.append(i);
            builder.append('[');
            builder.append(_lists[i] != null ? _lists[i].toString() : "--");
            builder.append("]\n");
        }
        return builder.toString();
    }

    public int getCount() {return _itemsCount;}
    /**
     * List
     */
    public class List<K, V> {
    
        private Node _root = null;

        private boolean add(Entity entity) {
            Node newNode = new Node(entity);
            if (_root == null) {
                _root = newNode;
                return true;
            }
            Node currNode = _root;
            while (currNode != null) {
                if (currNode._entity._key.equals(entity._key)) return false;
                if (currNode._next == null) {
                    currNode._next = newNode;
                    return true;
                }
                currNode = currNode._next;
            }
            return false;
        }

        public boolean add(K key, V value) {
            Entity entity = new Entity(key, value);
            return this.add(entity);
        }

        public boolean remove(K key) {
            if (_root == null) return false;
            if (_root._entity._key == key) {
                _root = _root._next;
                return true;
            }
            Node currNode = _root;
            while (currNode._next != null) {
                if (currNode._next._entity._key.equals(key)) {
                    currNode._next = currNode._next._next;
                    return true;
                }
                currNode = currNode._next;
            }
            return false;
        }

        public V getValue(K key) {
            Node currNode = _root;
            while (currNode != null) {
                if (currNode._entity._key.equals(key))
                    return currNode._entity._value;
                currNode = currNode._next;
            }
            return null;
        }

        public boolean setValue(K key, V value) {
            Node currNode = _root;
            while (currNode != null) {
                if (currNode._entity._key.equals(key)) {
                    currNode._entity._value = value;
                    return true;
                } currNode = currNode._next;
            }
            return false;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder('[');
            Node currNode = _root;
            while (currNode._next != null) {
                builder.append('{');
                builder.append(currNode._entity != null ? currNode._entity._key : "--");
                builder.append(':');
                builder.append(' ');
                builder.append(currNode._entity != null ? currNode._entity._value : "--");
                builder.append('}');
                builder.append(',');
                builder.append(' ');
                currNode = currNode._next;
            }
            builder.append('{');
            builder.append(currNode._entity != null ? currNode._entity._key : "--");
            builder.append(':');
            builder.append(' ');
            builder.append(currNode._entity != null ? currNode._entity._value : "--");
            builder.append('}');
            return builder.toString();
        }
        /**
         * Node
         */
        public class Node {
        
            private Entity _entity;
            private Node _next = null;

            Node(Entity entity) {this._entity = entity;}
        }

        /**
         * Entity
         */
        public class Entity {
        
            K _key;
            V _value;

            Entity() {}
            Entity(K key, V value) {this._key = key; this._value = value;}
        }
    }
}