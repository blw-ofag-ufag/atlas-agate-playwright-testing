package model;
import lombok.Builder;

@Builder
public record TestUser(
        String agateNumber,
        String salutation,
        String fullName,
        String birthYear,
        String email,
        String mobile,
        String address,
        String phone,
        String language
) {}
