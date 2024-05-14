package i0.sealights.demo.calculator.api;

import i0.sealights.demo.calculator.service.CalculatorService;
import i0.sealights.demo.calculator.service.EvaluationException;
import java.util.Enumeration;
import java.util.Random;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
    
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping("/evaluate/{expression}")
    public Result evaluateExpression3(final @PathVariable("expression") String expression) {

        LOG.info("expression is: " + expression);

        final double result = calculatorService.eval(expression);

        return new Result(result);
    }

    /*
     * Randomly wrong value returned 
     */
    @GetMapping("/calc/{expression}")
    public String calcExpression3(final @PathVariable("expression") String expression) {

        LOG.info("expression is: " + expression);

        final double randomError = Math.random();

        final double result = calculatorService.eval(expression) + randomError;

        return "Result if '"+expression+"' is " + result;
    }

    @ExceptionHandler({EvaluationException.class})
    public ResponseEntity<ErrorResult> handleEvaluationExceptions(EvaluationException exception) {
        final ErrorResult errorResult = new ErrorResult(exception.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResult> handleOtherExceptions(Exception exception) {
        final ErrorResult errorResult = new ErrorResult("Nobody expects the Spanish Inquisition: " + exception.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }
}
