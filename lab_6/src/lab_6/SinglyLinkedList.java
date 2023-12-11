package lab_6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node with the provided data.

		if (isEmpty()) {
			// If the list is empty, both head and tail should point to the new node.
			head = newNode;
			tail = newNode;
		} else {
			// If the list is not empty, set the new node as the new head.
			newNode.next = head; // Make the new node point to the current head.
			head = newNode; // Update the head to the new node.
		}

		size++; // Increase the size of the list.
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Tạo một nút mới với dữ liệu được cung cấp.

		if (isEmpty()) {
			// Nếu danh sách rỗng, cả 'head' và 'tail' đều trỏ đến nút mới này.
			head = newNode;
			tail = newNode;
		} else {
			// Nếu danh sách không rỗng, cập nhật 'tail' hiện tại để trỏ đến nút mới.
			tail.next = newNode;
			tail = newNode;
		}

		size++; // Tăng kích thước của danh sách.
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty()) {
			return null; // Trả về null khi danh sách rỗng (hoặc xử lý theo cách khác).
		}

		E removedData = head.getData(); // Lấy dữ liệu từ `head` hiện tại.
		head = head.next; // Cập nhật `head` để trỏ đến nút tiếp theo.

		size--; // Giảm kích thước của danh sách.
		return removedData;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty()) {
			return null; // Trả về null khi danh sách rỗng (hoặc xử lý theo cách khác).
		}

		E removedData;
		if (size == 1) {
			// Trường hợp đặc biệt khi chỉ có một phần tử trong danh sách.
			removedData = head.getData();
			head = null;
			tail = null;
		} else {
			// Lặp để tìm nút thứ hai từ cuối.
			Node<E> current = head;
			while (current.next != tail) {
				current = current.next;
			}
			removedData = tail.getData();
			tail = current;
			tail.next = null;
		}

		size--; // Giảm kích thước của danh sách và trả về dữ liệu đã loại bỏ.
		return removedData;
	}
	 public static void main(String[] args) {
	        // Tạo một danh sách liên kết đơn
	        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

	        // Thêm các phần tử vào danh sách
	        linkedList.addFirst(1);
	        linkedList.addLast(2);
	        linkedList.addLast(3);

	        // In ra số lượng phần tử trong danh sách
	        System.out.println("Size of the linked list: " + linkedList.size());

	        // In ra các phần tử của danh sách
	        System.out.println("Elements in the linked list:");
	        printLinkedList(linkedList);

	        // Loại bỏ phần tử đầu tiên và in ra nó
	        Integer removedFirst = linkedList.removeFirst();
	        System.out.println("Removed first element: " + removedFirst);

	        // Loại bỏ phần tử cuối cùng và in ra nó
	        Integer removedLast = linkedList.removeLast();
	        System.out.println("Removed last element: " + removedLast);

	        // In ra danh sách sau khi loại bỏ
	        System.out.println("Elements in the linked list after removal:");
	        printLinkedList(linkedList);
	    }

	    // Phương thức để in ra các phần tử của danh sách liên kết
	    private static void printLinkedList(SinglyLinkedList<Integer> linkedList) {
	        Node<Integer> current = linkedList.head;
	        while (current != null) {
	            System.out.print(current.getData() + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }

}
