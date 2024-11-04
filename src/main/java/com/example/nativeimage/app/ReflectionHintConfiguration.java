package com.example.nativeimage.app;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@RegisterReflectionForBinding({TestPojo.class})
public class ReflectionHintConfiguration {
}
