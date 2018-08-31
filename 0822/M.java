   public void purge(Comparator<? super E> c) {
      Node<E> ptr = head;

      while (ptr != null) {
         int count = 0;
         Node<E> ptr2 = ptr;
         Node<E> pre = ptr;

         while (pre.next != null) {
            ptr2 = pre.next;
            if (c.compare(ptr.data, ptr2.data) == 0) {
               pre.next = ptr2.next;
               count++;
            } else
               pre = ptr2;
         }
         if (count == 0)
            ptr = ptr.next;
         else {
            Node<E> temp = ptr;
            remove(ptr);
            ptr = temp.next;
         }
      }
      crnt = head;
   }
