package Board;

import Objects.ICellObject;

import java.util.Arrays;

public class List implements IList<ICellObject> {

    private int length;
    private ICellObject[] data;

    public List(int initialSize) {
        length = 0;
        data = new ICellObject[initialSize];
    }

    @Override
    public void add(ICellObject e) {
        if (length == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[length] = e;
        length++;
    }

    @Override
    public ICellObject remove(int i) {
        ICellObject e = data[i];

        for (int j = i; j < length - 1; j++) {
            data[j] = data[j + 1];
        }
        length--;
        return e;
    }

    @Override
    public ICellObject get(int i) {
        return data[i];
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void set(int i, ICellObject e) {
        data[i] = e;
    }

    @Override
    public void clear() {
        length = 0;
    }
}
