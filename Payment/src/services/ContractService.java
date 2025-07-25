package services;

import entities.Contract;
import entities.Installment;
import interfaces.OnlinePaymentService;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basciQuota = contract.getTotalValue()/ months;

        for(int i=1;i <= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interst = onlinePaymentService.interest(basciQuota,i);
            double fee = onlinePaymentService.paymentFee(basciQuota + interst);
            double quota = basciQuota +interst+fee;

            contract.getInstallment().add(new Installment(dueDate,quota));
        }
    }
}
