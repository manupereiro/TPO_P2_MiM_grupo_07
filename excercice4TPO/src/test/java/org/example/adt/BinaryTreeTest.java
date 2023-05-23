package org.example.adt;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private IBinaryTree tree;

    @BeforeEach
    public void init(){
        tree = new BinaryTree();
    }

    @Test
    @DisplayName("Debería agregar un elemento arbitrario como raíz")
    public void create(){

        assertTrue(tree.isEmpty());
        RuntimeException exceptionRight = assertThrows(RuntimeException.class, () -> {tree.getRight();});
        assertEquals(exceptionRight.getMessage(), "The tree is empty");
        RuntimeException exceptionLeft = assertThrows(RuntimeException.class, () -> {tree.getLeft();});
        assertEquals(exceptionLeft.getMessage(), "The tree is empty");
        tree.create(1);
        assertNull(tree.getRight());
        assertNull(tree.getLeft());
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.getValue());
        assertNull(tree.getLeft());
        assertNull(tree.getRight());

    }

    @Test
    @DisplayName("Debería devolver un valor la raíz del árbol")
    public void getValue(){

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {tree.getValue();});
        assertEquals(exception.getMessage(), "The tree is empty");
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNotNull(tree.getValue());
        assertFalse(tree.isEmpty());
        assertEquals(1,tree.getValue());
    }

    @Test
    @DisplayName("Debería comprobar si la raíz existe")
    public void isEmpty(){

        assertTrue(tree.isEmpty());
        tree.create(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    @DisplayName("Debería comprobar si se agrego un elemento a la derecha de la raíz")
    public void addRight(){

        assertTrue(tree.isEmpty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {tree.addRight(3);});
        assertEquals(exception.getMessage(), "The tree is empty");
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getRight());
        tree.addRight(2);
        assertNotNull(tree.getRight());
        assertEquals(2,tree.getRight().getValue());
    }

    @Test
    @DisplayName("Debería comprobar si se agrego un elemento a la derecha de la raíz")
    public void addLeft(){

        assertTrue(tree.isEmpty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {tree.addLeft(1);});
        assertEquals(exception.getMessage(), "The tree is empty");
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getLeft());
        tree.addLeft(3);
        assertNotNull(tree.getLeft());
        assertEquals(3,tree.getLeft().getValue());
    }

    @Test
    @DisplayName("Debería comprobar si se borro el elemento derecho de la raíz")
    public void removeRight(){

        assertTrue(tree.isEmpty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {tree.removeRight();});
        assertEquals(exception.getMessage(), "The tree is empty");
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getRight());
        tree.addRight(2);
        assertNotNull(tree.getRight());
        tree.removeRight();
        assertNull(tree.getRight());
    }
    @Test
    @DisplayName("Debería comprobar si se borro el elemento izquierdo de la raíz")
    public void removeLeft(){

        assertTrue(tree.isEmpty());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {tree.removeLeft();});
        assertEquals(exception.getMessage(), "The tree is empty");
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getLeft());
        tree.addLeft(2);
        assertNotNull(tree.getLeft());
        tree.removeLeft();
        assertNull(tree.getLeft());
    }

    @Test
    @DisplayName("Debería obtener el valor del elemento derecho de la raíz")
    public void getRight(){

        assertTrue(tree.isEmpty());
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getRight());
        tree.addRight(2);
        assertNotNull(tree.getRight());
        assertEquals(2, tree.getRight().getValue());
    }

    @Test
    @DisplayName("Debería obtener el valor del elemento izquierdo de la raíz")
    public void getLeft(){

        assertTrue(tree.isEmpty());
        tree.create(1);
        assertNotNull(tree.getValue());
        assertNull(tree.getLeft());
        tree.addLeft(2);
        assertNotNull(tree.getLeft());
        assertEquals(2, tree.getLeft().getValue());
    }
}
