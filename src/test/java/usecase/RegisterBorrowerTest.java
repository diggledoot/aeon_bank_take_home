package usecase;

import com.aeon.library.borrower.BorrowerRepository;
import com.aeon.library.borrower.usecase.RegisterBorrower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterBorrowerTest {
    @InjectMocks
    private RegisterBorrower registerBorrower;

    @Mock
    private BorrowerRepository borrowerRepository;

    private static final String mockName = "mockName";
    private static final String mockEmail = "mockEmail@mail.com";

    @Test
    void success() {
        // Act
        registerBorrower.execute(mockName, mockEmail);

        // Assert
        verify(borrowerRepository).register(mockName, mockEmail);
    }

    @Test
    void throwException() {
        // Arrange
        doThrow(DataRetrievalFailureException.class).when(borrowerRepository).register(mockName, mockEmail);

        // Act
        Executable executable = () -> registerBorrower.execute(mockName, mockEmail);

        // Assert
        Assertions.assertThrows(DataAccessException.class, executable);
    }
}
