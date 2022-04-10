import React from "react";
import styled from "styled-components";

const StyledPanel = styled.div`
    background-color: green;
    min-height: 100px;
    max-height: 100vh;
    font-size: 24px;
    border-radius: 5px;
`;

const Panel = ({user}) => (
    <StyledPanel>{user.pseudo + " " + user.email}</StyledPanel>
);

export default Panel;