import styled from "styled-components";

export const Container = styled.div`
    display:flex;
    flex-direction: column;
    margin-left :35%;
    padding: 10px;
    width:20%
    align-items:center;
`

export const AccountBox = styled.div`
    display:flex;
    flex-direction: row;
`

export const AccountTitle = styled.h4`
    color: "black";
    margin-right: 5px
`

export const AccountAmount = styled.h4`
    color:red;
`

export const ButtonsWrapper = styled.div`
    display:flex;
    flex-direction: row;
`

export const Input = styled.input`
  padding: 0.5em;
  margin: 0.5em;
  color: "palevioletred";
  background: papayawhip;
  border: none;
  border-radius: 3px;
`;

export const Button = styled.button`
  background: "white";
  color: "palevioletred";
  font-size: 1em;
  margin: 1em;
  padding: 0.25em 1em;
  border: 2px solid palevioletred;
  border-radius: 3px;
`;

export const Error = styled.div`
    width:600px;
    margin-top: 20px;
    text-align:center
    color:red
`