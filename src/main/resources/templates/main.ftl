<div class="container">
    <div class="customers">
        <div class="container-input" style="margin-left: 50px;">
            <div class="customer-input" align="center" valign="middle">
                Fill the table customers
                <form action="/customer/customer-create" method="post">
                    <input type="text" name="customerName" placeholder="Customer name">
                    <input type="text" name="phoneNumber" placeholder="Phone">
                    <input type="text" name="email" placeholder="Email">
                    <input type="text" name="address" placeholder="Address">
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
        <#if customers?has_content>
            <table class="table-customer" align="center" valign="middle" style="margin-left: 50px;">
                <tr class="tableHeader">
                    <td>customerId</td>
                    <td>CustomerName</td>
                    <td>Email</td>
                    <td>phoneNumber</td>
                    <td>address</td>
                    <td>creditCards ID</td>
                </tr>
                <#list customers as customer>
                    <tr class="tableBody">
                        <td>${customer.customerId}</td>
                        <td>${customer.customerName}</td>
                        <td>${customer.email}</td>
                        <td>${customer.phoneNumber}</td>
                        <td>${customer.address}</td>
                        <td>
                            <#list customer.getCreditCards() as credit_card>${credit_card.cardId},</#list>
                        </td>
                    </tr>
                </#list>
            </table>
            <div class="container-delete" style="margin-left: 50px;">
                <div class="customer-input" align="center" valign="middle">
                    select customer id to delete
                    <form action="/customer/customer-delete" method="post">
                        <input type="text" name="customerId" placeholder="Customer Id">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </div>
        <#else>
            There are no customers yet.
        </#if>
    </div>
    <div class="credit-cards">
        <div class="container-input" style="margin-left: 50px;">
            <div class="credits-cards-input" align="center" valign="middle">
                Fill the table credits cards
                <form action="/credit/credit-create" method="post">
                    <input type="text" name="cardNumber" placeholder="card Number">
                    <input type="text" name="cardHolderName" placeholder="Card Holder Name">
                    <input type="text" name="expirationDate" placeholder="Expiration Date">
                    <input type="text" name="cvv" placeholder="CVV">
                    <input type="text" name="customer_id" placeholder="customer id">
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
        <#if credit_cards?has_content>
            <div class="table-credit_cards" style="margin-left: 50px;">
                <table border="1" cellspacing="0" cellpadding="1">
                    <tr class="tableHeader">
                        <td>cardId</td>
                        <td>cardNumber</td>
                        <td>cardHolderName</td>
                        <td>expirationDate</td>
                        <td>cvv</td>
                    </tr>
                    <#list credit_cards as credit_card>
                        <tr class="tableBody">
                            <td>${credit_card.cardId}</td>
                            <td>${credit_card.cardNumber}</td>
                            <td>${credit_card.cardHolderName}</td>
                            <td>${credit_card.expirationDate}</td>
                            <td>${credit_card.cvv}</td>
                        </tr>
                    </#list>
                </table>
            </div>
            <div class="container-delete" style="margin-left: 50px;">
                <div class="credit-input" align="center" valign="middle">
                    select card id to delete
                    <form action="/credit/credit-delete" method="post">
                        <input type="text" name="creditId" placeholder="Credit card Id">
                        <button type="submit">Delete</button>
                    </form>
                </div>
            </div>
        <#else>
            There are no credit cards yet.
        </#if>
    </div>
</div>
