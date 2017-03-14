package com.test.demo.design.iterator;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class IteratorTest {

    public static void main(String[] args){
        RealCollection<Integer> collection = new RealCollection<>(new Integer[]{1,6,2,76,2});
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.print(integer.intValue() + " : ");
        }
        System.out.println("");
        RealCollection<String> collection1 = new RealCollection<>(new String[]{"a","b","c"});
        Iterator<String> iterator1 = collection1.iterator();
        while (iterator1.hasNext()){
            String str = iterator1.next();
            System.out.print(str + " : ");
        }
        System.out.println("");

    }

    public static class RealCollection<T> implements Collection<T>{

        public RealCollection(T[] data){
            this.data = data;
        }

        private T[] data;

        @Override
        public Iterator iterator() {
            return new RealIterator<T>(this);
        }

        @Override
        public int size() {
            return data.length;
        }

        @Override
        public T get(int i) {
            if(i > -1 && i < data.length) {
                return data[i];
            }
            return null;
        }
    }

    public static class RealIterator<T> implements Iterator<T>{

        private Collection<T> mCollection;
        private int position = -1;

        public RealIterator(Collection collection){
            mCollection = collection;
        }

        @Override
        public T pre() {
            if(position > 0){
                position--;
                return mCollection.get(position);
            }
            return null;
        }

        @Override
        public T next() {
            if(position < mCollection.size() - 1){
                position ++;
                return mCollection.get(position);
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return position < mCollection.size() -1;
        }

        @Override
        public T first() {
            return mCollection.get(0);
        }
    }
}
