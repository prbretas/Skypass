package com.startech.skypass.dao;

import com.startech.skypass.dto.ClientDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "client_address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@IdClass(ClientAddressId.class)
@DynamicUpdate
public class ClientAddressDAO {
    @Id
    @NotNull
    private String clientId;

    @Id
    @NotNull
    private String addressId;
}