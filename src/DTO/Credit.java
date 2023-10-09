package DTO;

import INTERFACES.CreditStatut;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public final class Credit {
    private int creditNum;
    @NonNull
    private double creditBalance;
    @NonNull
    private CreditStatut statut;
    @NonNull
    private LocalDate CreationDate;
    @NonNull
    private Client client;
}