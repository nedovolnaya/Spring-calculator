package pro.sky.skyproSpringCalcuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showWelcoming() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.sum(num1, num2);
        return num1 + "+" + num2 + "=" + result;
    }

    @GetMapping("/minus")
    public String substract(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.substract(num1, num2);
        return num1 + "-" + num2 + "=" + result;

    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + result;

    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        int result = calculatorService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + result;

    }


}
