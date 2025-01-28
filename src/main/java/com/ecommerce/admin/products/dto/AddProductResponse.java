package com.ecommerce.admin.products.dto;

import com.ecommerce.common.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddProductResponse extends BaseResponse {
    private String id;
    private String name;
    private String category;
    private String subCategory;
    private String quantity;
}
