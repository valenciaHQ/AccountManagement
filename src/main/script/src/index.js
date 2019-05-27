import React, {Component} from "react";
import {render} from "react-dom";
import {AccountAmount, AccountBox, AccountTitle, Button, ButtonsWrapper, Container, Error, Input} from './styled'

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accountData: undefined,
            debit: '',
            credit: '',
            error: ''
        };
    }

    componentWillMount() {
        this.fetchData();
    }

    onChange = e =>
        this.setState({[e.target.name]: e.target.value})

    fetchData = () => {
        fetch(
            'http://localhost:8080/api/account',
            {
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

    handleDebit = () => {
        fetch(
            'http://localhost:8080/api/account/transaction/debit',
            {
                method: 'POST',
                body: JSON.stringify({amount: this.state.debit}),
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        )
            .then(response => {
                return response && response.status === 400 ? response.json() : response
            })
            .then(data => {
                data.errorCode && data.errorCode === 400 && this.setState({error: data.message})
                this.fetchData()
            })
            .catch(rejected => {
                console.log(rejected);
            });
    };

    handleCredit = () => {
        fetch(
            'http://localhost:8080/api/account/transaction/credit',
            {
                method: 'POST',
                body: JSON.stringify({amount: this.state.credit}),
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        )
            .then(response => response)
            .then(data => data.status === 200 && this.fetchData())
            .catch(rejected => {
                console.log(rejected);
            });
    };

    render() {
        const {accountData, debit, credit, error} = this.state;
        return (
            <Container>
                <AccountBox>
                    <AccountTitle>Current Amount:</AccountTitle>
                    <AccountAmount>{accountData}</AccountAmount>
                </AccountBox>
                <ButtonsWrapper>
                    <Input
                        name="debit"
                        value={debit}
                        onChange={e => this.onChange(e)}
                    />
                    <Button onClick={this.handleDebit}>Debit</Button>
                    <Input
                        name="credit"
                        value={credit}
                        onChange={e => this.onChange(e)}
                    />
                    <Button onClick={this.handleCredit}>Credit</Button>
                </ButtonsWrapper>
                {error && (<Error>{error}</Error>)}
            </Container>
        )
    }
}

render(<App/>, document.getElementById("root"));
