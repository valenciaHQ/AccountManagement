import React, {Component} from "react";
import {render} from "react-dom";
import {AccountAmount, AccountBox, AccountTitle, Button, ButtonsWrapper, Container, Input} from './styled'

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accountData: undefined,
            debitValue: undefined,
            creditValue: undefined
        };
    }

    componentWillMount() {
        this.fetchAPI();
    }

    fetchAPI = () => {
        fetch(
            'http://localhost:8080/api/account',
            {
                crossDomain: false,
                method: 'GET'
            }
        )
            .then(response => response.json())
            .then(data => {
                this.setState({accountData: data.amount})
            })
            .catch(rejected => {
                console.log(rejected);
            });
    };

    render() {
        const {accountData} = this.state;
        return (
            <Container>
                <AccountBox>
                    <AccountTitle>Current Amount:</AccountTitle>
                    <AccountAmount>{accountData}</AccountAmount>
                </AccountBox>
                <ButtonsWrapper>
                    <Button onClick={this.handleDebit}>Debit</Button>
                    <Input value={this.state.debitValue}/>
                    <Button onClick={this.handleDebit}>Credit</Button>
                    <Input value={this.state.creditvalue}/>
                </ButtonsWrapper>
            </Container>
        )
    }
}

render(<App/>, document.getElementById("root"));
