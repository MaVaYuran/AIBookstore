package by.mariayuran.bookstore.servlets;

import by.mariayuran.bookstore.library.LibraryRepository;
import by.mariayuran.bookstore.model.Book;
import by.mariayuran.bookstore.service.OrderServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookOrderServletTest {
    @Mock
    OrderServiceImpl orderService;
    @Mock
    protected HttpServletRequest request;
    @Mock
    protected HttpServletResponse response;
    @Mock
    protected RequestDispatcher dispatcher;
    @InjectMocks
    BookOrderServlet servlet;
    @Mock
    LibraryRepository libraryRepository;

    @Test
    public void givenCorrectBookTitle_thanMethodForwardToOrderDetailsPage() throws ServletException, IOException {
//        List<Book> bookList = List.of(new Book("Hobbit",19.95));
//
//        when(libraryRepository.loadLibrary()).thenReturn(bookList);
//        when(request.getParameter("title")).thenReturn("Hobbit");
//        when(request.getRequestDispatcher("/jsp/order_details.jsp")).thenReturn(dispatcher);
//
//        servlet.doPost(request, response);
//
//        verify(request).setAttribute("order", any());
//        verify(dispatcher).forward(request, response);
    }
}