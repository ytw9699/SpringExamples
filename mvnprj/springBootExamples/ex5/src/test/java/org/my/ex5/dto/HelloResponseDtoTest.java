package org.my.ex5.dto;
    import org.junit.jupiter.api.Test;
    import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lomboktest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);//assertThat은 assertj 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);//assertj의 동등 비교 메소드
    }
}