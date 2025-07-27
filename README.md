# Food App Backend

This is the backend for the Food Order App.  
Currently, it only includes **Stripe payment method integration** to support secure payments on the frontend.

## Features
- Stripe API integration for handling payments.
- Basic Spring Boot setup.
- REST API endpoints for payment processing.

## Tech Stack
- **Java 17**
- **Spring Boot**
- **Stripe API**

## Setup Instructions

1. **Clone the repository**
    ```bash
    git clone https://github.com/FiazZafar/Food_App_Backend.git
    ```
2. **Navigate to the project directory**
    ```bash
    cd Food_App_Backend
    ```
3. **Configure Stripe keys**  
   Create an `application.properties` file (not committed to the repo) with:
    ```properties
    stripe.secret.key=your_stripe_secret_key
    stripe.publishable.key=your_stripe_publishable_key
    ```
4. **Run the application**
    ```bash
    ./mvnw spring-boot:run
    ```

## API Endpoint
- **POST /api/payment/create-payment-intent**  
  Creates a new Stripe Payment Intent for frontend integration.

## Notes
- Keep your Stripe keys safe. Do **not** commit them to the repository.
- Use test keys for development and real keys only in production.
